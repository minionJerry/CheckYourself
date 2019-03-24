package com.kanykeinu.checkyourself.ui.subjectsList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.kanykeinu.checkyourself.R
import kotlinx.android.synthetic.main.subject_list_fragment.*

class SubjectListFragment : Fragment() {

    private lateinit var viewModel: SubjectListViewModel

    private lateinit var adapter: SubjectAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.subject_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGridView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SubjectListViewModel::class.java)
        viewModel.subjectList.observe(this, Observer { list ->
            adapter.list = list
        })
    }

    private fun initGridView(){
        rv_subjects.hasFixedSize()
        adapter = SubjectAdapter(context!!)
        rv_subjects.adapter = adapter
    }

}
