package com.example.todolist.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.databinding.ActivityAddTaskBinding
import com.example.todolist.datasource.TaskDataSource
import com.example.todolist.extensions.format
import com.example.todolist.extensions.text
import com.example.todolist.model.Task
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    //pega o xml e cria classes pra eles
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //já abre o xml
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //se possuir nosso id
        if (intent.hasExtra(TASK_ID)){
            val taskId = intent.getIntExtra(TASK_ID, 0)
            TaskDataSource.findById(taskId)?.let {
                binding.tilTitle.text=it.title
                binding.tilDate.text=it.date
                binding.tilHour.text=it.hour
            }
        }
        insertListeners()
    }

    private fun insertListeners() {
        binding.tilDate.editText?.setOnClickListener{
            val datePicker=MaterialDatePicker.Builder.datePicker().build()
            //quando o usuario clicar mostrar a data
            datePicker.addOnPositiveButtonClickListener {
                //pra nao pegar data errada
                val timeZone = TimeZone.getDefault()
                val offset=timeZone.getOffset(Date().time)*-1
                binding.tilDate.text = (Date(it+offset).format())
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }
        binding.tilHour.editText?.setOnClickListener {
            val timePicker=MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_24H).build()
            timePicker.addOnPositiveButtonClickListener {

                val minute = if (timePicker.minute in 0..9) "0${timePicker.minute}" else timePicker.minute
                val hour = if (timePicker.hour in 0..9) "0${timePicker.hour}" else timePicker.hour

                //binding.tilHour.text="${timePicker.hour} : ${timePicker.minute}"
                binding.tilHour.text="$hour:$minute"

            }
            timePicker.show(supportFragmentManager, null)
        }

        //clicar no botao de cancelar
        binding.btnCancel.setOnClickListener {
            finish()
        }

        binding.btnNewTask.setOnClickListener {
            //botao de adicionar
            val task=Task(title=binding.tilTitle.text, date= binding.tilDate.text,hour= binding.tilHour.text,
            id=intent.getIntExtra(TASK_ID, 0))
            TaskDataSource.insertTask(task)
            setResult(Activity.RESULT_OK)
            finish()
            Log.e("TAG", "insertListeners: "+ TaskDataSource.getList())
        }
    }

    companion object{
        const val TASK_ID="task_id"
    }



}