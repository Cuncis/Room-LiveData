package com.cuncis.roomlivedatakotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.cuncis.roomlivedatakotlin.utils.Util.EXTRA_DESCRIPTION
import com.cuncis.roomlivedatakotlin.utils.Util.EXTRA_TITLE
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)

        btn_save.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        if (et_title.text.toString().trim().isBlank() || et_desc.text.toString().trim().isBlank()) {
            Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
            return
        }

        val data = Intent().apply {
            putExtra(EXTRA_TITLE, et_title.text.toString())
            putExtra(EXTRA_DESCRIPTION, et_desc.text.toString())
        }

        setResult(Activity.RESULT_OK, data)
        finish()
    }

}
