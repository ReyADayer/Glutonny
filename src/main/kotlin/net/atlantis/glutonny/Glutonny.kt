package net.atlantis.glutonny

import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.toliner.korgelin.api.KotlinMod
import net.toliner.korgelin.container.KotlinModLoadingContext
import org.apache.logging.log4j.LogManager

@KotlinMod(Glutonny.modId)
object Glutonny {

    val logger = LogManager.getLogger("Glutonny")
    const val modId = "glutonny"
    const val modName = "Glutonny"

    init {
        KotlinModLoadingContext.get().eventBus.apply {

        }
    }

    val itemGroup: ItemGroup = object : ItemGroup(modId) {
        override fun createIcon() = ItemStack(Items.DIAMOND)
    }
}