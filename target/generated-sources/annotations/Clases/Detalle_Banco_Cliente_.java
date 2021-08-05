package Clases;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Detalle_Banco_Cliente.class)
public abstract class Detalle_Banco_Cliente_ {

	public static volatile SingularAttribute<Detalle_Banco_Cliente, Integer> Id_cliente;
	public static volatile SingularAttribute<Detalle_Banco_Cliente, Double> tasa_interes;
	public static volatile SingularAttribute<Detalle_Banco_Cliente, Integer> cuota;
	public static volatile SingularAttribute<Detalle_Banco_Cliente, String> fecha_inicio;
	public static volatile SingularAttribute<Detalle_Banco_Cliente, Integer> numero_prestamo;
	public static volatile SingularAttribute<Detalle_Banco_Cliente, String> fecha_final;
	public static volatile SingularAttribute<Detalle_Banco_Cliente, Double> valor_capital;
	public static volatile SingularAttribute<Detalle_Banco_Cliente, Double> monto_prestamo;
	public static volatile SingularAttribute<Detalle_Banco_Cliente, Double> valor_interes;
	public static volatile SingularAttribute<Detalle_Banco_Cliente, Integer> id_banco;

}

