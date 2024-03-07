package com.example.task.bindingAdapters

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.States.State
import com.example.task.base.BaseViewHolder



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

@BindingAdapter("manageState")
fun <T> manageState(progressBar: ProgressBar, state: State<T>?) {
    progressBar.visibility = if (state is State.Loading) View.VISIBLE else View.GONE
}
@BindingAdapter("noDatacachedError")
fun <T> noDatacachedError(tv: TextView, state: State<T>?) {
    if (state is State.NoDataCached){
        tv.text = state.message
        tv.visibility = View.VISIBLE
    }else{
        tv.visibility = View.GONE
    }
}