package com.awashwinter.mynotes.adapters

import androidx.recyclerview.widget.DiffUtil
import com.awashwinter.mynotes.room.entity.MyNote

class NoteDiffUtilCallback(private val oldList: List<MyNote>, private val newList: List<MyNote>):
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]

}