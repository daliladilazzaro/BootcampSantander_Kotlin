package com.example.todolist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.datasource.TaskDataSource
//data store e room
class MainActivity : AppCompatActivity() {

    private val adapter by lazy { TaskListAdapter() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

       // binding.rvTasks.adapter=adapter
        updateList()
        insertListeners()
    }
    private fun insertListeners(){
        binding.fab.setOnClickListener {
//            startActivity(Intent(this, AddTaskActivity::class.java))
            val intent=Intent(this, AddTaskActivity::class.java)
            intent.putExtra(AddTaskActivity.TASK_ID, it.id)
            startActivityForResult(intent, CREATE_NEW_TASK)

        }
        adapter.listenerEdit = {
            //Log.e("TAG", "listenerEdit: $it", )
            startActivityForResult(Intent(this, AddTaskActivity::class.java), CREATE_NEW_TASK)

        }
        adapter.listenerDelete = {
           // Log.e("TAG", "listenerDelete: $it", )
            TaskDataSource.deleteTask(it)
            updateList()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CREATE_NEW_TASK && requestCode==Activity.RESULT_OK) updateList()
           // binding.rvTasks.adapter=adapter
            //adapter.submitList(TaskDataSource.getList())

    }

    private fun updateList(){
        val list = TaskDataSource.getList()
        //adapter.submitList(TaskDataSource.getList())
       // binding.includeEmpty.emptyState.visibility = View.VISIBLE

        binding.includeEmpty.emptyState.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE

        adapter.submitList(list)
    }

    companion object{
        private const val CREATE_NEW_TASK=1000
    }
}