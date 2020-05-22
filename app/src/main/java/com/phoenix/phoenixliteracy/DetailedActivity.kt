package com.phoenix.phoenixliteracy

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detailed.*

class DetailedActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val TITLE = "TITLE"
        const val DESC = "DESCRIPTION"
        const val PAGE = "PAGE NUMBER"
        const val DATE = "PUBLISH DATE"
        const val IMG = "IMAGE"
        const val URL = "URL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        obtainData()

        val actionbar: ActionBar? = supportActionBar
        actionbar!!.title = "Booklet Detail"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val btnMoveWithDataActivity: Button = findViewById(R.id.download_button)
        btnMoveWithDataActivity.setOnClickListener(this)
    }

    fun obtainData(){
        val tvTitle: TextView = findViewById(R.id.booklet_title)
        val tvDescription: TextView = findViewById(R.id.booklet_detailed)
        val tvPageNum: TextView = findViewById(R.id.booklet_page)
        val tvPublishDate: TextView = findViewById(R.id.booklet_date)
        val ivCover: ImageView = findViewById(R.id.imageView)

        tvTitle.text = intent.getStringExtra(TITLE)
        tvDescription.text = intent.getStringExtra(DESC)
        tvPageNum.text = "${intent.getIntExtra(PAGE, 0)} halaman"
        tvPublishDate.text = "Terbit: ${intent.getStringExtra(DATE)}"
        ivCover.setImageResource(intent.getIntExtra(IMG,0))

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.download_button -> {
                val url = intent.getStringExtra(URL)
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
        }
    }
}
