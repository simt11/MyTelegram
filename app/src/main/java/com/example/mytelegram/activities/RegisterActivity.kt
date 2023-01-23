package com.example.mytelegram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.mytelegram.ui.fragments.EnterPhoneNumberFragment
import com.example.vovatelegram.R
import com.example.vovatelegram.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        toolbar = binding.registerToolbar
        setSupportActionBar(toolbar)
        title = getString(R.string.register_totle_your_phone)
        supportFragmentManager.beginTransaction()
            .add(R.id.registerDataContainer, EnterPhoneNumberFragment())
            .commit()
    }
}

// объявление самого класса RegisterActivity, который наследуется (двоеточие :)
// от абстрактного класса Activity. Это базовый класс для всех экранов приложения.
// У вас будет AppCompatActivity. В старых версиях не было плюшек, которые появились
// после Android 4, поэтому для них была создана специальная библиотека совместимости,
// которая позволяет использовать новинки от новых версий Android в старых программах.
// Класс AppCompatActivity как раз и относится к библиотеке совместимости.
// Считайте её родственником базовой Activity.
// У неё есть все нужные методы и вспомогательные классы,
// но названия могут немного различаться.


//Объявляем приватное свойство binding (А инициализация потом)- типом ActivityRegisterBinding.
// Этот тип представляет собой сгенерированный класс,
// который создается при использовании библиотеки привязки данных Android
// для привязки элементов пользовательского интерфейса в файле макета XML к объектам данных.

//В самом классе мы видим метод onCreate() – он вызывается,
// когда приложение создаёт и отображает разметку активности.
// Метод помечен ключевым словом override (переопределён из базового класса).
// Ключевое слово может пригодиться вам. Если вы сделаете опечатку в имени метода,
// то компилятор сможет предупредить вас,
// сообщив об отсутствии такого метода у родительского класса Activity.

//Строка super.onCreate(savedInstanceState) – это конструктор родительского класса,
// выполняющий необходимые операции для работы активности.
// Эту строчку вам не придётся трогать, оставляйте без изменений.

// Метод 'onCreate' является переопределением метода из 'AppCompatActivity' класса.
// Он вызывается при первом создании активности.
// В этом случае 'binding' свойство инициализируется вызовом 'ActivityRegisterBinding.inflate'
// и передачей файла 'LayoutInflater'. Используется 'LayoutInflater' для увеличения макета,
// указанного в 'binding' объекте, и возврата корневого представления для действия.
// Это корневое представление затем устанавливается
// в качестве представления содержимого для действия, использующего 'setContentView' метод.