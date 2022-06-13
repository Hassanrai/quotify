package bismillah.kotlin.quotify

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.nio.charset.Charset

class MainViewModel(val context : Context): ViewModel() {
    private var quoteList: Array<Quote> = emptyArray()
    private var index: Int = 0

    init {
        quoteList = loadQuotes()
    }

    private fun loadQuotes(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json: String = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<Quote>::class.java)
    }

    fun getQuote() = quoteList[index]

    fun nextQuote() =quoteList[++index % quoteList.size]

    fun prevQuote() = quoteList[(--index + quoteList.size) % quoteList.size]

}