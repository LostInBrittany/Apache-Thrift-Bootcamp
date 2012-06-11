namespace java com.arkea.thrift.service.chatroom

include "message.thrift"
include "utilisateur.thrift"
include "exception.thrift"

/** Service ChatRoomService */
service ChatRoomService {
	
	/** Recupérer la liste des Messages */
	list<message.Message> getListeMessage() 
                       throws (1:exception.ServiceException se)
	
	/** Envoyer un message */
	void envoyerMessage(1:message.Message message) 
                       throws (1:exception.ServiceException se)

	/** Enregistrer un utilisateur */
	void enregistrerUtilisateur (1: utilisateur.Utilisateur utilisateur) 
                       throws (1:exception.ServiceException se)
}