package org.example.decorator.examples

import java.awt.Color
import java.util.concurrent.TimeUnit

interface Message {
    fun process(body: String): String
}


open class MessageDecorator(private val message: Message) : Message {
    override fun process(body: String): String {
        return message.process(body)
    }
}

class MessageWithHeader(message: Message) : MessageDecorator(message) {
    override fun process(body: String): String {
        val message = """
            Hello. I'm Adib Faramarzi and I'm glad to be messaging you.
            $body
            """

        return super.process(message)
    }
}

class MessageWithFooter(message: Message) : MessageDecorator(message) {
    override fun process(body: String): String {
        val message = """
            $body
            
            Best regards,
            --
            @AdibCodes (YouTube & Telegram)
            """

        return super.process(message)
    }
}

class SpellCheckedMessage(message: Message) : MessageDecorator(message) {
    override fun process(body: String): String {
        return fixSpelling(super.process(body))
    }

    private fun fixSpelling(body: String): String {
        return "Fixed spelling: \n$body"
    }
}

class BasicMessage() : Message {
    override fun process(body: String): String {
        return body
    }
}

fun main() {
    val message = SpellCheckedMessage(
                            MessageWithHeader(
                                    MessageWithFooter(
                                            BasicMessage()
                                    )
                            )
                        ).process("Hope you're enjoying the video.")

    println(message)
}
