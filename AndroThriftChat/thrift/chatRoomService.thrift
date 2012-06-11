namespace java com.arkea.thrift.service.chatroom

include "message.thrift"
include "utilisateur.thrift"

/** Service ChatRoomService */
service ChatRoomService {

	/** Recupérer la liste des Messages */
	list<message.Message> getListeMessage()

	/** Envoyer un message */
	void envoyerMessage(1:message.Message message)

	/** Enregistrer un utilisateur */
	void enregistrerUtilisateur 
		(1: utilisateur.Utilisateur utilisateur)

}