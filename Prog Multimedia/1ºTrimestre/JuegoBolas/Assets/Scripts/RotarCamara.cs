using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RotarCamara : MonoBehaviour

{
    public float velocidad = 5;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        float entradaHorizontal = Input.GetAxis("Horizontal");

        transform.Rotate(Vector3.up, velocidad * Time.deltaTime * entradaHorizontal);
    }
}
