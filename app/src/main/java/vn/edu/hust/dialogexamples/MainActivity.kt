package vn.edu.hust.dialogexamples

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    findViewById<Button>(R.id.button_show).setOnClickListener {
//      AlertDialog.Builder(this)
//        .setIcon(R.mipmap.ic_launcher_round)
//        .setTitle("Test dialog")
//        .setMessage("This is a test dialog")
//        .setPositiveButton("Yes",
//          { _, _ -> Log.v("TAG", "Yes is clicked")})
//        .setNegativeButton("No",
//          { _, _ -> Log.v("TAG", "No is clicked")})
//        .setNeutralButton("Cancel", null)
//        .show()
//        .setCanceledOnTouchOutside(false)

      val items = mutableListOf<String>()
      for (i in 1..50)
        items.add("Item $i")

//      AlertDialog.Builder(this)
//        .setTitle("Select an option")
//        .setItems(items.toTypedArray(),
//          { _, position -> Log.v("TAG", "$position")})
//        .setPositiveButton("Cancel", null)
//        .show()

//      AlertDialog.Builder(this)
//        .setTitle("Select an option")
//        .setSingleChoiceItems(items.toTypedArray(), 0,
//          { _, position: Int -> Log.v("TAG", "$position")})
//        .setPositiveButton("OK", { _, _ -> })
//        .setNegativeButton("Cancel", null)
//        .show()

//      val selections = BooleanArray(items.size)
//
//      AlertDialog.Builder(this)
//        .setTitle("Select an option")
//        .setMultiChoiceItems(items.toTypedArray(), selections,
//          { _, pos: Int, isSelected: Boolean -> Log.v("TAG", "$pos: $isSelected")})
//        .setPositiveButton("OK", { _, _ -> })
//        .setNegativeButton("Cancel", null)
//        .show()


//      val dialogView = LayoutInflater.from(this)
//        .inflate(R.layout.layout_alert_dialog, null)
//
//      val editHoten = dialogView.findViewById<EditText>(R.id.edit_hoten)
//      val editMssv = dialogView.findViewById<EditText>(R.id.edit_mssv)
//
//      AlertDialog.Builder(this)
//        .setTitle("Nhap thong tin sinh vien")
//        .setView(dialogView)
//        .setPositiveButton("OK", { _, _ ->
//          val hoten = editHoten.text.toString()
//          val mssv = editMssv.text.toString()
//          Log.v("TAG", "$hoten - $mssv")
//        })
//        .setNegativeButton("Cancel", null)
//        .show()


//      val dialog = Dialog(this)
//      dialog.setContentView(R.layout.layout_dialog)
//      val editHoten = dialog.findViewById<EditText>(R.id.edit_hoten)
//      val editMssv = dialog.findViewById<EditText>(R.id.edit_mssv)
//      dialog.findViewById<Button>(R.id.button_ok).setOnClickListener {
//        val hoten = editHoten.text.toString()
//        val mssv = editMssv.text.toString()
//        Log.v("TAG", "$hoten - $mssv")
//        dialog.dismiss()
//      }
//      dialog.findViewById<Button>(R.id.button_cancel).setOnClickListener {
//        dialog.dismiss()
//      }
//      dialog.window?.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
//      dialog.show()

//      TestDialogFragment().show(supportFragmentManager, "TAG")

//      DatePickerDialog(this,
//        { _, year: Int, month: Int, day: Int -> Log.v("TAG", "$year - $month - $day")},
//        2024, 11, 14).show()

//      TimePickerDialog(this,
//        { _, hour, minute -> Log.v("TAG", "$hour:$minute")},
//        10, 59, true).show()

//      Toast.makeText(this, "Hello Android", Toast.LENGTH_LONG)
//        .show()

      Snackbar.make(it, "Hello Android!", Snackbar.LENGTH_LONG)
        .setAction("UNDO", {})
        .show()
    }
  }
}