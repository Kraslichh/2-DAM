using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ControlGeneracioin : MonoBehaviour
{
    // Start is called before the first frame update
    public GameObject prefabEnemigo;
    private float rangoGeneracion = 9.0f;
    void Start()
    {

        Instantiate(prefabEnemigo, DamePosicionGeneracion(), prefabEnemigo.transform.rotation);
    }

    // Update is called once per frame
    void Update()
    {
    }
    Vector3 DamePosicionGeneracion()
    {
        float posXGeneracion = Random.Range(-rangoGeneracion, rangoGeneracion);
        float posYGeneracion = Random.Range(-rangoGeneracion, rangoGeneracion);
        Vector3 posAleatoria = new Vector3(posXGeneracion, 0, posYGeneracion);
        return posAleatoria;
    }
}
