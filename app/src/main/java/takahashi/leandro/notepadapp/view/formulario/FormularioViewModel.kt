package takahashi.leandro.notepadapp.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import takahashi.leandro.notepadapp.model.Nota
import takahashi.leandro.notepadapp.model.ResponseStatus
import takahashi.leandro.notepadapp.repository.NotaRepository

class FormularioViewModel: ViewModel() {
    val notaRepository = NotaRepository()
    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()
            fun salvar(titulo: String, descricao: String) {
                val nota = Nota(null, titulo, descricao)
                notaRepository.
                        salvar(
                                nota,
                                onComplete = {
                                    responseStatus.value = ResponseStatus(true, "" )
                                },
                                onError = {

                                    responseStatus.value = ResponseStatus(false, it?.message!! )
                                }
                        )
            }
}

