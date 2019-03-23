package com.kanykeinu.checkyourself.ui.detailedResult

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kanykeinu.checkyourself.R

class DetailedResultFragment : Fragment() {

    companion object {
        fun newInstance() = DetailedResultFragment()
    }

    private lateinit var viewModel: DetailedResultViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detailed_result_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailedResultViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
