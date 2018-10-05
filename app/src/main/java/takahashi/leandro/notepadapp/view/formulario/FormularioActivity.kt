package takahashi.leandro.notepadapp.view.formulario

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_formulario.*
import takahashi.leandro.notepadapp.R
import takahashi.leandro.notepadapp.model.ResponseStatus

class FormularioActivity : AppCompatActivity() {

    lateinit var formularioViewModel: FormularioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        formularioViewModel = ViewModelProviders.of(this)
                .get(FormularioViewModel::class.java)
        formularioViewModel.responseStatus.observe(this, responseStatusObserver)

        btSalvar.setOnClickListener{
            formularioViewModel.salvar(
                    edtitulo.text.toString(),
                    eddescricao.text.toString()
            )
        }
    }


    private var responseStatusObserver = Observer<ResponseStatus> {
        if (it?.sucesso == true) {
            setResult(Activity.RESULT_OK)
            finish()
        } else {
            Toast.makeText(this, it?.mensagem, Toast.LENGTH_SHORT).show()

        }
    }

}
