package io.noobymatze.knack.effects


/**
 * A [Cmd] represents a description of a side effect.
 */
sealed class Cmd<out Msg> {

    internal object None: Cmd<Nothing>()

    internal class Batch<out Msg>(val commands: Array<out Cmd<Msg>>): Cmd<Msg>()

    internal class Effect<out Msg>(val run: ((Msg) -> Unit) -> Unit): Cmd<Msg>()

    /**
     * @param f
     */
    fun <NewMsg> map(f: (Msg) -> NewMsg): Cmd<NewMsg> = when (this) {
        None ->
            None

        is Batch ->
            Batch(commands.map { it.map(f) }.toTypedArray())

        is Effect ->
            Effect { r -> run { r(f(it)) } }
    }

    companion object {

        /**
         * A constant [Cmd] which means, there is nothing to do.
         */
        val none: Cmd<Nothing> = None

        /**
         * Returns a new [Cmd], which runs the given commands. Whether this
         * happens concurrently or sequentially depends on the [Executor].
         *
         * @param commands a number of commands
         * @return a new [Cmd]
         */
        fun <Msg> batch(vararg commands: Cmd<Msg>): Cmd<Msg> =
            if (commands.isEmpty())
                none
            else
                Batch(commands)

        /**
         * Returns a new [Cmd] representing an effect.
         *
         * @param f a function which takes another function, which will
         * be called when a message has been computed.
         * @return a new [Cmd]
         */
        fun <Msg> effect(f: ((Msg) -> Unit) -> Unit): Cmd<Msg> =
            Effect(f)

    }

}