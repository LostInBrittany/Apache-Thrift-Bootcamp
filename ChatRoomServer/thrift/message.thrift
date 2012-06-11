namespace java com.arkea.thrift.data.message

include "utilisateur.thrift"

/**
* Structure Message
**/
struct Message {

	/** contenu Message */
   	1:string contenu,

   	/** utilisateur ayant ecrit le Message */
   	2:utilisateur.Utilisateur utilisateur,
}