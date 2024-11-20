package vn.edu.hust.dialogexamples

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val students = mutableListOf<String>()
    private lateinit var adapter: StudentAdapter
    private var selectedPosition = -1
    private var lastDeletedStudent: String? = null
    private var lastDeletedPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_students)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter(students) { position ->
            selectedPosition = position
            // Optional: Show a toast to indicate selection
            Toast.makeText(this, "Selected: ${students[position]}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.button_add_new).setOnClickListener {
            showAddStudentDialog()
        }

        findViewById<Button>(R.id.button_edit).setOnClickListener {
            if (selectedPosition >= 0) {
                showEditStudentDialog(selectedPosition)
            } else {
                Toast.makeText(this, "Please select a student to edit", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.button_delete).setOnClickListener {
            if (selectedPosition >= 0) {
                showDeleteStudentDialog(selectedPosition)
            } else {
                Toast.makeText(this, "Please select a student to delete", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showAddStudentDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.layout_alert_dialog, null)
        val editHoten = dialogView.findViewById<EditText>(R.id.edit_hoten)
        val editMssv = dialogView.findViewById<EditText>(R.id.edit_mssv)

        AlertDialog.Builder(this)
            .setTitle("Add New Student")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val hoten = editHoten.text.toString()
                val mssv = editMssv.text.toString()
                students.add("$hoten - $mssv")
                adapter.notifyItemInserted(students.size - 1)
                Log.v("TAG", "Added: $hoten - $mssv")
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showEditStudentDialog(position: Int) {
        if (position < 0 || position >= students.size) return

        val dialogView = LayoutInflater.from(this).inflate(R.layout.layout_alert_dialog, null)
        val editHoten = dialogView.findViewById<EditText>(R.id.edit_hoten)
        val editMssv = dialogView.findViewById<EditText>(R.id.edit_mssv)

        val student = students[position].split(" - ")
        editHoten.setText(student[0])
        editMssv.setText(student[1])

        AlertDialog.Builder(this)
            .setTitle("Edit Student")
            .setView(dialogView)
            .setPositiveButton("Update") { _, _ ->
                val hoten = editHoten.text.toString()
                val mssv = editMssv.text.toString()
                students[position] = "$hoten - $mssv"
                adapter.notifyItemChanged(position)
                Log.v("TAG", "Updated: $hoten - $mssv")
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showDeleteStudentDialog(position: Int) {
        if (position < 0 || position >= students.size) return

        AlertDialog.Builder(this)
            .setTitle("Delete Student")
            .setMessage("Are you sure you want to delete this student?")
            .setPositiveButton("Delete") { _, _ ->
                lastDeletedStudent = students[position]
                lastDeletedPosition = position
                students.removeAt(position)
                adapter.notifyItemRemoved(position)
                selectedPosition = -1 // Reset selection
                showUndoSnackbar()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showUndoSnackbar() {
        Snackbar.make(findViewById(R.id.root_layout), "Student deleted", Snackbar.LENGTH_LONG)
            .setAction("UNDO") {
                lastDeletedStudent?.let {
                    students.add(lastDeletedPosition, it)
                    adapter.notifyItemInserted(lastDeletedPosition)
                    Log.v("TAG", "Restored: $it")
                }
            }
            .show()
    }
}