using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ControlJugador : MonoBehaviour
{
    // Start is called before the first frame update
    private Rigidbody rbJugador;
    private GameObject puntoEnfoque;
    public float velocidad = 5.0f;

    void Start()
    {
        rbJugador = GetComponent<Rigidbody>();
        puntoEnfoque = GameObject.Find("Punto de Enfoque");

    }

    // Update is called once per frame
    void Update()
    {
        float entradaAvance = Input.GetAxis("Vertical");
        float entradaLateral = Input.GetAxis("Horizontal");

        // de esta manera será el punto de enfoque hacia adelante lo que cambiará  y se moverá la camara
        //tambien hacia adelante
        rbJugador.AddForce(puntoEnfoque.transform.forward * entradaAvance * velocidad);
        rbJugador.AddForce(puntoEnfoque.transform.right * entradaLateral * velocidad);

    }
}
