package Clases;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SingularAttribute<Pedido, Double> monto_pedido;
	public static volatile SingularAttribute<Pedido, String> fecha_pedido;
	public static volatile SingularAttribute<Pedido, Boolean> estado;
	public static volatile SingularAttribute<Pedido, String> fecha_entrega;
	public static volatile SingularAttribute<Pedido, Integer> id_pedido;

}

