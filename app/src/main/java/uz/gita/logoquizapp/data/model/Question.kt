package uz.gita.logoquizapp.data.model

data class Question(
    val question: Int,
    val answer: String,
    val variants : List<String>,
    var select: Int = -1
)
