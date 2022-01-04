package com.example.cryptoinfo.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoinfo.R
import com.example.cryptoinfo.adapters.NewsAdapter
import com.example.cryptoinfo.viewmodel.CryptoViewModel
import com.example.newssy.adapters.TopHeadlinesAdapter
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment() {
    lateinit var cryptoViewModel: CryptoViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var topHeadlinesAdapter: TopHeadlinesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initApi()
        setObserver()
        ivMakeSearch.visibility = View.VISIBLE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    private fun initApi() {
        ivSearch.setOnClickListener {
            if (edtInput.text.toString().isEmpty()) {
                edtInput.error = "Enter some keyword to search"
            } else {
                ivMakeSearch.visibility = View.GONE
                Toast.makeText(requireContext(), "Here you go (: ", Toast.LENGTH_SHORT).show()
                cryptoViewModel.fetchNewsData(edtInput.text.toString())

            }
        }

        cryptoViewModel.fetchTopHeadlines()
    }

    private fun setObserver() {
        cryptoViewModel.successNewsData().observe(requireActivity(), Observer {
            newsAdapter = NewsAdapter(requireContext(), it.articles)
            rvNews.adapter = newsAdapter
            rvNews.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        })
        cryptoViewModel.failureData().observe(requireActivity(), Observer {
            var failureMessage = it.toString()
            Toast.makeText(requireContext(), failureMessage, Toast.LENGTH_SHORT).show()
        })

        cryptoViewModel.successHeadlinesData().observe(requireActivity(), Observer {
            topHeadlinesAdapter = TopHeadlinesAdapter(requireContext(), it.articles)
            rvTopHeadlines.adapter = topHeadlinesAdapter
            rvTopHeadlines.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        })
    }

    private fun initViewModel() {
        cryptoViewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)

    }

}