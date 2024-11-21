package cris.PawPetCare.microservicios.typeservice;

public class Care extends TypeService{
    public Care(float cost) {
        super(cost);
    }
    @Override
    public float paymentValue(float cost) {
        return cost*(0.1f+1);
    }

}
