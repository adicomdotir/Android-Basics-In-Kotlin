package ir.adicom.app.androidbasicsinkotlin.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.adicom.app.androidbasicsinkotlin.network.MarsApi
import ir.adicom.app.androidbasicsinkotlin.network.MarsPhoto
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<MarsPhoto>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    val photo: LiveData<MarsPhoto> = _photos
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()[0]
                _status.value = "   First Mars image URL : ${_photos.value!!.imgSrcUrl}"
            }
            catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}