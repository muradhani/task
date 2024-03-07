package com.example.task.bindingAdapters

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.States.State
import com.example.domain.models.product.Product
import com.example.task.base.BaseRecyclerViewAdapterAdapter
import com.example.task.base.BaseViewHolder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@BindingAdapter("setImage")
fun loadImage(view: View, imgurl:String){
    Glide.with(view.context).load(imgurl).into(view as ImageView)
}

@BindingAdapter("setAdapter")
fun <DB : ViewDataBinding> setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<BaseViewHolder<DB>>?) {
    adapter?.let {
        view.adapter = it
    }
}
//@BindingAdapter("submitList")
//fun <T, DB : ViewDataBinding> submitList(view: RecyclerView, state: State<List<T>>?) {
//    if (state is State.Success) {
//        val adapter = view.adapter as BaseRecyclerViewAdapterAdapter<DB,T>?
//        adapter!!.setData(state.data)
//    }
//}

@BindingAdapter("manageState")
fun <T> manageState(progressBar: ProgressBar, state: State<T>?) {
    progressBar.visibility = if (state is State.Loading) View.VISIBLE else View.GONE
}
