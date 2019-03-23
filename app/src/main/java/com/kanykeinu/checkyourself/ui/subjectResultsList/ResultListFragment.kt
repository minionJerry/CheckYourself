package com.kanykeinu.checkyourself.ui.subjectResultsList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kanykeinu.checkyourself.R

class ResultListFragment : Fragment() {

    companion object {
        fun newInstance() = ResultListFragment()
    }

    private lateinit var viewModel: ResultListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.result_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ResultListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
