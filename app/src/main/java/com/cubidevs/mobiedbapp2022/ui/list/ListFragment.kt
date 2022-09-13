package com.cubidevs.mobiedbapp2022.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubidevs.mobiedbapp2022.databinding.FragmentListBinding
import com.cubidevs.mobiedbapp2022.server.model.citiesListItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private var citiesList: ArrayList<citiesListItem> = ArrayList()
    private lateinit var citiesAdapter: CitiesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = listBinding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        citiesAdapter = CitiesAdapter(citiesList, onItemClicked = { onCityItemClicked(it) })

        listBinding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = citiesAdapter
            setHasFixedSize(false)
        }

        listViewModel.citiesLoaded.observe(viewLifecycleOwner){result ->
            onCitiesLoadedSuscribe(result)
        }

        listViewModel.getCities()
    }

    private fun onCityItemClicked(city: citiesListItem) {
        findNavController().navigate(ListFragmentDirections.actionNavigationListToDetailFragment(city))
    }

    private fun onCitiesLoadedSuscribe(citiesList: ArrayList<citiesListItem>) {
        citiesList.let { citiesList ->
            citiesAdapter.appendItems(citiesList)
        }
    }
}