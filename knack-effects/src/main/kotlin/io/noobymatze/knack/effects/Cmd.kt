package io.noobymatze.knack.effects


/**
 * A [Cmd] represents a description of a side effect.
 */
sealed class Cmd<out Msg> {

    internal object None: Cmd<Nothing>()

    internal class Batch<out Msg>(val commands: Array<out Cmd<Msg>>): Cmd<Msg>()

    internal class Effect<out Msg>(val f: () -> Msg): Cmd<Msg>()

    companion object {

        val none: Cmd<Nothing> = None

        fun <Msg> batch(vararg commands: Cmd<Msg>): Cmd<Msg> =
            Batch(commands)

        fun <Msg> effect(f: () -> Msg): Cmd<Msg> =
            Effect(f)

    }

}