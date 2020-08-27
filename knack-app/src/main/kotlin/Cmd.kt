sealed class Cmd<out Msg> {

    internal object None: Cmd<Nothing>()

    internal class Batch(val commands: Array<out Cmd<Msg>>): Cmd<Msg>()

    internal class Effect(val f: () -> Msg): Cmd<Msg>()

    companion object {

        val none: Cmd<Nothing> = None

        fun batch(vararg commands: Cmd<Msg>): Cmd<Msg> =
            Batch(commands)

        fun effect(f: () -> Msg): Cmd<Msg> =
            Effect(f)

    }

}