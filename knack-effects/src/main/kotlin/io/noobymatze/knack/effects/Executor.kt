package io.noobymatze.knack.effects


interface Executor {

    /**
     *
     */
    fun <Msg> run(cmd: Cmd<Msg>, sendToApp: (Msg) -> Unit)


    /**
     *
     */
    class Sync: Executor {

        override fun <Msg> run(cmd: Cmd<Msg>, sendToApp: (Msg) -> Unit): Unit =
            when (cmd) {
                Cmd.None -> Unit
                is Cmd.Batch -> cmd.commands.forEach { subCmd ->
                    run(subCmd, sendToApp)
                }

                is Cmd.Effect ->
                    try {
                        cmd.run(sendToApp)
                    } catch (ex: Exception) {
                        console.log(ex)

                    }
            }

    }

}
