package com.example.implementandotestes

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ContactHelperTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val sharePreferences =
        context.getSharedPreferences("com.exemple.implementandoteste.PREFERENCE", Context.MODE_PRIVATE)
    private val contactHelper = ContactHelper(sharePreferences)
    @Test
    fun `Quando Chamar o Metodo getListContacts() com 2 contatos, deve retornar uma lista de 2 contatos`() {
        //preparar e validar
      //  TODO("Implementa preparação de nock")
        mockListaDoisContatos()
        //TODO("Valida valores de método")
        val list = contactHelper.getListContacts()
        assertEquals(2,list.size)
    }
    @Test
    fun `Quando chamar o método  getListContacts() sem contatos, deve retornar uma lista vazia`(){
        //prepara
       // TODO("Prepara o mock de lista vazia")
        mockListaContatosVazia()
        // valida
      //  TODO("Valida retorno com a lista vazia")
        val list = contactHelper.getListContacts()
        assertEquals(2,list.size)
    }

    private  fun mockListaDoisContatos(){
        contactHelper.setListContact(arrayListOf(
            Contact("James Ruan", "(88)96547-3654", "img.jpeg"),
            (Contact("Mario Lopes", "(99)94568-4756", "img2.jpeg")))
    }
    private fun mockListaContatosVazia(){
        contactHelper.setListContact(arrayListOf())
    }
}