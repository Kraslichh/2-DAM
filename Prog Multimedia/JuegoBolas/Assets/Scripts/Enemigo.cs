using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemigo : MonoBehaviour
{
    // Start is called before the first frame update
    private Rigidbody rbEnemigo;
    private GameObject jugador;
    public float velocidad = 3;
    void Start()
    {

        rbEnemigo = GetComponent<Rigidbody>();
        jugador = GameObject.Find("Jugador");
    }

    // Update is called once per frame
    void Update()
    {
        Vector3 vectorAlObjetivo = (jugador.transform.position - transform.position).normalized;
        rbEnemigo.AddForce(vectorAlObjetivo * velocidad);


    }
}