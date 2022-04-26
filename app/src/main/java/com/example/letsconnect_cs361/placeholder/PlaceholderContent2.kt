package com.example.letsconnect_cs361.placeholder

import java.util.ArrayList
import java.util.HashMap

object PlaceholderContent2 {
        /**
         * An array of sample (placeholder) items.
         */
        val ITEMS: MutableList<PlaceholderItem> = ArrayList()

        /**
         * A map of sample (placeholder) items, by ID.
         */
        val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

        private val COUNT = 8
        init {
            ITEMS.add(PlaceholderItem("1", "Mom", ""))
            ITEMS.add(PlaceholderItem("2", "Dad", ""))
            ITEMS.add(PlaceholderItem("3", "Sister", ""))
            ITEMS.add(PlaceholderItem("4", "Uncle Tom", ""))
            ITEMS.add(PlaceholderItem("5", "Auntie Anne", ""))

            // Add some sample items.
            for (i in 6..COUNT) {
                addItem(createPlaceholderItem(i))
            }
        }

        private fun addItem(item: PlaceholderItem) {
            ITEMS.add(item)
            ITEM_MAP.put(item.id, item)
        }

        private fun createPlaceholderItem(position: Int): PlaceholderItem {
            return PlaceholderItem(position.toString(), "Family/Friend " + position, makeDetails(position))
        }

        private fun makeDetails(position: Int): String {
            val builder = StringBuilder()
            builder.append("Details about Item: ").append(position)
            for (i in 0..position - 1) {
                builder.append("\nMore details information here.")
            }
            return builder.toString()
        }

        /**
         * A placeholder item representing a piece of content.
         */
        data class PlaceholderItem(val id: String, val content: String, val details: String) {
            override fun toString(): String = content
        }
    }
