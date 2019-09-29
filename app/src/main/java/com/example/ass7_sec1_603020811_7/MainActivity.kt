package com.example.ass7_sec1_603020811_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*

class MainActivity : AppCompatActivity() {
    val employee = arrayListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testEmployeeData()
        recycler_view.adapter = EmployeeAdapter(this.employeeList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
    }
    fun addEmployee(v:View){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener(
            employeeList.add(Employee(mDialogView.edt_name.text.toString(), mDialogView.edt_email.text.toString(),
                mDialogView.edt_salary.text.toString()))
        recycler_view.adater?.notifyDataSetChanged()
        Toast.makeText(applicationContext, "The employee is added successfully", Toast.LENGTH_SHORT).show()
        mAlertDialog.dismiss()
        )
        mDialogView.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }

    fun testEmployeeData(){
        employeeList.add(Employee("baimon", "Femal", "baimon@gmail.com", 5000))
        employeeList.add(Employee("baimon","Femail", "baimon@gmail.com", 5000))
    }
}
