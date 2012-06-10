namespace java com.arkea.thrift.data.utilisateur

/**
* Structure utilisateur
**/
struct Utilisateur {

	/** pseudo Utilisateur */
	1:string pseudo,

	/** mot de passe */
	2:string motdepasse,
}