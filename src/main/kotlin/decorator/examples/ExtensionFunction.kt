package org.example.decorator.examples.other


interface Message {
    fun process(body: String): String
}


open class MessageDecorator() : Message {
    var other: Message = BasicMessage()
    fun then(other: Message): MessageDecorator {
        this.other = other
        return this
    }

    override fun process(body: String): String {
        return other.process(body)
    }
}

class MessageWithHeaderDecorator() : MessageDecorator() {
    override fun process(body: String): String {
        val message = """
            Hello. I'm Adib Faramarzi and I'm glad to be messaging you.
            $body
            """

        return super.process(message)
    }
}

class MessageWithFooterDecorator() : MessageDecorator() {
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

class CompressedMessageDecorator() : MessageDecorator() {
    override fun process(body: String): String {
        println("Compressed is receiving $body")
        return compress(super.process(body))
    }

    private fun compress(message: String): String {
        return "compressed[$message]"
    }
}

class SpellCheckedMessage() : MessageDecorator() {
    override fun process(body: String): String {
        return sendToServer(super.process(body))
    }

    private fun sendToServer(body: String): String {
        return "Fixed spelling...: \n$body"
    }
}

class BasicMessage() : Message {
    override fun process(body: String): String {
        return body
    }
}

fun main() {
    val message = SpellCheckedMessage()
        .then(CompressedMessageDecorator())
        .then(MessageWithHeaderDecorator())
        .then(MessageWithFooterDecorator())
    .process("Hope you're enjoying the video.")

    println(message)
}