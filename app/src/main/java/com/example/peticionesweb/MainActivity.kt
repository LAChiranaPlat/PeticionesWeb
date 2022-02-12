package com.example.peticionesweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.peticionesweb.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var currentActivity: ActivityMainBinding

    lateinit var colaPeticiones:RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        currentActivity= ActivityMainBinding.inflate(layoutInflater)
        val btnRequest=currentActivity.btnReq
        val nId=currentActivity.etxtId
        val titulo=currentActivity.txtTitle
        val contenido=currentActivity.txtContent

        setContentView(currentActivity.root)

        colaPeticiones=Volley.newRequestQueue(this)

        //GET       =>      URL             PUBLICO     255 CARACTERES
        //POST      =>      HEADER          PRIVADO     ENORME  (UPLOADING:)

        btnRequest.setOnClickListener {
            Log.i("result","Listener")

            val url="http://192.168.1.200/myApp/wService.php?name=Jose&lname=Perez"

            /*val request=StringRequest(
                Request.Method.GET,
                url,
                Response.Listener { respuesta->
                    Log.i("result","Data recibida: ${respuesta.toString()}")
                },
                Response.ErrorListener { errorRespuesta->
                    Log.i("result","Error detectado: ${errorRespuesta.toString()}")
                }
            )*/

            val request=JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                Response.Listener { resp->
                    Log.i("result","Data: ${resp.toString()}")
                },
                Response.ErrorListener { eResp->
                    Log.i("result","Error detectado: ${eResp.toString()}")
                }
                )

/*             val request=JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                Response.Listener { resp->
                    Log.i("result","Objeto Recivido: [Tamaño ${resp.length()}]")

                    for(item in 0 until resp.length() ) {

                    val obj=JSONObject(resp.get(item).toString())
                    Log.i("result","Contenido #$item: ${obj.getString("body")}")

                    }

                },
                Response.ErrorListener { eResp->
                    Log.i("result","Error detectado: ${eResp.toString()}")
                }
                )*/

            colaPeticiones.add(request)
        }

    }

}