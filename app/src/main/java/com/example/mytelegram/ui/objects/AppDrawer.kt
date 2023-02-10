package com.example.mytelegram.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mytelegram.ui.fragments.SettingsFragment
import com.example.vovatelegram.R
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

private const val ID_CREATE_GROUPS: Long     = 1
private const val ID_SECRET_CHAT: Long       = 2
private const val ID_CREATE_CHANEL: Long     = 3
private const val ID_CONTACTS: Long          = 4
private const val ID_PHONE: Long             = 5
private const val ID_FAVORITES: Long         = 6
private const val ID_SETTINGS: Long          = 7
private const val ID_INVITE: Long            = 8
private const val ID_HELP: Long              = 9

class AppDrawer(val mainActivity: AppCompatActivity, val toolbar: Toolbar) {
    private lateinit var drawer: Drawer
    private lateinit var header: AccountHeader

    fun create() {
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        drawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(header)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(ID_CREATE_GROUPS)
                    .withIconTintingEnabled(true)
                    .withName(R.string.create_groups)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_groups),
                PrimaryDrawerItem().withIdentifier(ID_SECRET_CHAT)
                    .withIconTintingEnabled(true)
                    .withName(R.string.secret_chat)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_secret_chat),
                PrimaryDrawerItem().withIdentifier(ID_CREATE_CHANEL)
                    .withIconTintingEnabled(true)
                    .withName(R.string.create_channel)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_channel),
                PrimaryDrawerItem().withIdentifier(ID_CONTACTS)
                    .withIconTintingEnabled(true)
                    .withName(R.string.contacts)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_contacts),
                PrimaryDrawerItem().withIdentifier(ID_PHONE)
                    .withIconTintingEnabled(true)
                    .withName(R.string.phone)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_phone),
                PrimaryDrawerItem().withIdentifier(ID_FAVORITES)
                    .withIconTintingEnabled(true)
                    .withName(R.string.favorites)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_favorites),
                PrimaryDrawerItem().withIdentifier(ID_SETTINGS)
                    .withIconTintingEnabled(true)
                    .withName(R.string.settings)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_settings),
                DividerDrawerItem(),
                PrimaryDrawerItem().withIdentifier(ID_INVITE)
                    .withIconTintingEnabled(true)
                    .withName(R.string.invite)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_invate),
                PrimaryDrawerItem().withIdentifier(ID_HELP)
                    .withIconTintingEnabled(true)
                    .withName(R.string.help)
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_help)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        ID_SETTINGS.toInt() -> mainActivity.supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.dataContainer, SettingsFragment()).commit()
                    }
                    return false
                }

            }).build()
    }

    private fun createHeader() {
        header = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName(R.string.default_user_name)
                    .withEmail(R.string.user_mail)
            ).build()
    }
}