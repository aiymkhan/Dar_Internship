package com.example.hw_3.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3.R
import com.example.hw_3.Student
import com.example.hw_3.StudentAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment() {


    private val students = mutableSetOf<Student>()
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<StudentAdapter.ViewHolder>? = null

    private fun contains(name: String?): Boolean {
        val names = mutableSetOf<String>()
        for(i in 0 .. students.size-1)
            students.elementAt(i).name?.let { names.add(it) }
        return names.contains(name)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_a, container, false)

        val btnAddStudent: Button = view.findViewById(R.id.btn_add_student)
        val etName: EditText = view.findViewById(R.id.et_name)

        val rv: RecyclerView = view.findViewById(R.id.rv_student_list)


        btnAddStudent.setOnClickListener {

            val student = Student(students.size+1, etName.text.toString())
            if (contains(student.name)) {
                Toast.makeText(getActivity(), "Student already in the list!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                students.add(student)
                adapter?.notifyItemInserted(students.size-1)
            }
            etName.setText("")

            Log.d("asd", students.toString())

        }
        rv.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = StudentAdapter()
            (adapter as StudentAdapter).submitList(students.toList())


        }



        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentA.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                FragmentA().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}