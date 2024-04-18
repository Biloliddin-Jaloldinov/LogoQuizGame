package uz.gita.logoquizapp.domain

import android.util.Log
import uz.gita.logoquizapp.R
import uz.gita.logoquizapp.data.model.Question
import kotlin.random.Random

class Repository private constructor() {
    private lateinit var questionsData: MutableList<Question>
    private lateinit var questions: ArrayList<Question>
    private lateinit var variants: ArrayList<String>

    companion object {
        private var repository: Repository? = null
        fun getInstance(): Repository {
            if (repository == null) {
                repository = Repository()
            }
            return repository!!
        }
    }

    init {
        loadVariants()
        loadData()
    }

    fun getScore(): Int {
        var count = 0
        for (i in 0 until questions.size) {
            val question = questions[i]
            if (question.select != -1 && question.variants[question.select] == question.answer) {
                count++
            }
        }
        return count
    }

    fun getQuestionByIndex(index: Int): Question {
        return questions[index]
    }

    fun getQuestionData() = questions

    fun setSelected(index: Int, selectedVariant: Int) {
        questions[index].select = selectedVariant
    }

    private fun loadVariants() {
        variants = ArrayList()
        variants.add("Adidas")
        variants.add("Amazon")
        variants.add("Android")
        variants.add("Facebook")
        variants.add("Firefox")
        variants.add("Gmail")
        variants.add("Google")
        variants.add("Instagram")
        variants.add("Lacoste")
        variants.add("Lego")
        variants.add("Nestle")
        variants.add("Pepsi")
        variants.add("Pizza Hut")
        variants.add("Playstation")
        variants.add("Puma")
        variants.add("Skype")
        variants.add("Snapchat")
        variants.add("Snickers")
        variants.add("Spotify")
        variants.add("Tesla")
        variants.add("Toyota")
        variants.add("Twitter")
        variants.add("Wikipedia")
        variants.add("Windows")
        variants.add("Xbox")
        variants.add("Audi")
        variants.add("Bluetooth")
        variants.add("BMW")
        variants.add("Burger King")
        variants.add("Chanel")
        variants.add("Chevrolet")
        variants.add("Coca Cola")
        variants.add("Daewoo")
        variants.add("Fanta")
        variants.add("Ferrari")
        variants.add("Fiat")
        variants.add("Ford")
        variants.add("Intel")
        variants.add("Jaguar")
        variants.add("KFC")
        variants.add("Lexus")
        variants.add("LG")
        variants.add("Lipton")
        variants.add("Mazda")
        variants.add("Mini")
        variants.add("Monster")
        variants.add("Mortal Kombat")
        variants.add("Motorola")
        variants.add("Nasa")
        variants.add("Netflix")
        variants.add("Opel")
        variants.add("Pringles")
        variants.add("Red Bull")
        variants.add("Samsung")
        variants.add("Shell")
        variants.add("Sprite")
        variants.add("Subaru")
        variants.add("Superman")
        variants.add("Suzuki")
        variants.add("Taco Bell")
        variants.add("Target")
        variants.add("Volvo")
        variants.add("Xerox")
        variants.add("YouTube")
    }

    private fun loadData() {
        questionsData = ArrayList()
        questions = ArrayList()
        questionsData.add(Question(R.drawable.logo_adidas, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_amazon, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_android, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_facebook, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_firefox, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_gmail, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_google, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_instagram, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_lacoste, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_lego, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_nestle, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_pepsi, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_pizza_hut, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_playstation, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_puma, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_skype, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_snapchat, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_snickers, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_spotify, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_tesla, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_toyota, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_twitter, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_wikipedia, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_windows, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.logo_xbox, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_audi, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_bluetooth, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_bmw, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_burger_king, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_chanel, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_chevrolet, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_coca_cola, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_daewoo, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_fanta, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_ferrari, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_fiat, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_ford, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_intel, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_jaguar, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_kfs, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_lexus, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_lg, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_lipton, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_mazda, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_mini, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_monster, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_mortal_combat, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_motorola, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_nasa, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_netflix, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_opel, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_pringles, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_red_bull, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_samsung, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_shell, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_sprite, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_subaru, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_supernan, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_suzuki, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_taco_bell, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_target, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_volvo, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_xerox, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.add(Question(R.drawable.img_logo_youtube, variants[questionsData.size], getVariants(variants[questionsData.size])))
        questionsData.shuffle()
        loadQuestion()

    }

    private fun loadQuestion() {
        for (i in 0 until 10)
            questions.add(questionsData[i])
    }

    private fun getVariants(answer: String): List<String> {
        val list = ArrayList<String>()
        list.add(answer)
        for (i in 1 until 4) {
            var firstAdd: Boolean
            do {
                firstAdd = true
                val variant = variants[Random.nextInt(0, variants.size)]
                for (j in 0 until list.size) {
                    if (list[j] == variant) {
                        firstAdd = false
                        break
                    }
                }
                if (firstAdd) {
                    list.add(variant)
                }
            } while (!firstAdd)
        }
        Log.d("TTT", "variant size ${variants.size}")
        return list.shuffled()
    }

    fun newGame() {
        questionsData.shuffle()
        questions.clear()
        clearSelects()
        loadQuestion()
    }

    private fun clearSelects() {
        questionsData.forEach {
            it.select = -1
        }
    }
}