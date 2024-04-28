package org.example.decorator.basic

open class Message() {
    open fun send(body: String){
        sendToServer(body)
    }
    private fun sendToServer(body: String) {
        // send to server

    }
}

open class MessageWithHeader(): Message() {
    override fun send(body: String) {
        val message = """
            Hello. I'm Adib Faramarzi and I'm glad to be messaging you.
            $body
            """
        super.send(message)
    }
}



open class MessageWithFooter(): Message() {
    override fun send(body: String) {
        val message = """
            $body
            
            Best regards,
            --
            @AdibCodes (YouTube & Telegram)
            """
        super.send(message)
    }
}



open class CompressedMessage(): Message() {
    override fun send(body: String) {
        val compressed = compress(body)
        super.send(compressed)
    }

    fun compress(body: String): String {
        body
        TODO("Not yet implemented")
    }
}

open class CompressedHeaderMessage(): Message() {
    override fun send(body: String) {
        val message = """
            Hello. I'm Adib Faramarzi and I'm glad to be messaging you.
            $body
            """
        val compressed = compress(message)
        super.send(compressed)
    }

    fun compress(body: String): String {
        body
        TODO("Not yet implemented")
    }
}






open class EncryptedMessage(): Message() {
    override fun send(body: String) {
        val encryptedBody = encrypt(body)
        super.send(encryptedBody)
    }

    fun encrypt(string: String): String {
        TODO("Not yet implemented")
    }
}

open class EncryptedCompressedMessage(): Message() {
    override fun send(body: String) {
        val encryptedBody = encrypt(body)
        val compressed = compress(encryptedBody)
        super.send(compressed)
    }

    fun encrypt(string: String): String {
        TODO("Not yet implemented")
    }
    fun compress(string: String): String {
        TODO("Not yet implemented")
    }
}


fun main() {
    val message = "Hope you're enjoying the video."
    val compressedHeaderMessage = CompressedHeaderMessage()

    compressedHeaderMessage.send(message)











    MessageWithHeader()
    CompressedMessage()
    CompressedHeaderMessage()
    MessageWithFooter()
    EncryptedMessage()
    EncryptedCompressedMessage()
}
































































interface UIComponent {
    fun draw()
}

class BorderComponent(): UIComponent {
    override fun draw() {
        drawBorder(1, Color.Black)
    }
}

class ShadowComponent(): UIComponent {
    override fun draw() {
        drawShadow(5)
        drawOverlay(Color.Disabled)
    }
}

class BorderWithShadowComponent(): UIComponent {
    override fun draw() {
        drawShadow(5)
        drawBorder(1, Color.Black)
    }
}



















fun drawBorder(i: Int, p1: Any){

}
fun drawShadow(i: Int){

}
fun drawOverlay(any: Any){

}

enum class Color {
    Black, Disabled
}











open class PricingComponent(val basePrice: Double) {
    open fun getPrice(): Double {
        return basePrice
    }
}

class DiscountedPrice(basePrice: Double): PricingComponent(basePrice) {
    override fun getPrice(): Double {
        return super.getPrice() * 0.9
    }
}
