//
// Autogenerated by Thrift Compiler (0.8.0)
//
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//


//HELPER FUNCTIONS AND STRUCTURES

ChatRoomService_getListeMessage_args = function(args) {
};
ChatRoomService_getListeMessage_args.prototype = {};
ChatRoomService_getListeMessage_args.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    input.skip(ftype);
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

ChatRoomService_getListeMessage_args.prototype.write = function(output) {
  output.writeStructBegin('ChatRoomService_getListeMessage_args');
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

ChatRoomService_getListeMessage_result = function(args) {
  this.success = null;
  this.se = null;
  if (args) {
    if (args.success !== undefined) {
      this.success = args.success;
    }
    if (args.se !== undefined) {
      this.se = args.se;
    }
  }
};
ChatRoomService_getListeMessage_result.prototype = {};
ChatRoomService_getListeMessage_result.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 0:
      if (ftype == Thrift.Type.LIST) {
        var _size0 = 0;
        var _rtmp34;
        this.success = [];
        var _etype3 = 0;
        _rtmp34 = input.readListBegin();
        _etype3 = _rtmp34.etype;
        _size0 = _rtmp34.size;
        for (var _i5 = 0; _i5 < _size0; ++_i5)
        {
          var elem6 = null;
          elem6 = new Message();
          elem6.read(input);
          this.success.push(elem6);
        }
        input.readListEnd();
      } else {
        input.skip(ftype);
      }
      break;
      case 1:
      if (ftype == Thrift.Type.STRUCT) {
        this.se = new ServiceException();
        this.se.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

ChatRoomService_getListeMessage_result.prototype.write = function(output) {
  output.writeStructBegin('ChatRoomService_getListeMessage_result');
  if (this.success) {
    output.writeFieldBegin('success', Thrift.Type.LIST, 0);
    output.writeListBegin(Thrift.Type.STRUCT, this.success.length);
    for (var iter7 in this.success)
    {
      if (this.success.hasOwnProperty(iter7))
      {
        iter7 = this.success[iter7];
        iter7.write(output);
      }
    }
    output.writeListEnd();
    output.writeFieldEnd();
  }
  if (this.se) {
    output.writeFieldBegin('se', Thrift.Type.STRUCT, 1);
    this.se.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

ChatRoomService_envoyerMessage_args = function(args) {
  this.message = null;
  if (args) {
    if (args.message !== undefined) {
      this.message = args.message;
    }
  }
};
ChatRoomService_envoyerMessage_args.prototype = {};
ChatRoomService_envoyerMessage_args.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRUCT) {
        this.message = new Message();
        this.message.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

ChatRoomService_envoyerMessage_args.prototype.write = function(output) {
  output.writeStructBegin('ChatRoomService_envoyerMessage_args');
  if (this.message) {
    output.writeFieldBegin('message', Thrift.Type.STRUCT, 1);
    this.message.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

ChatRoomService_envoyerMessage_result = function(args) {
  this.se = null;
  if (args) {
    if (args.se !== undefined) {
      this.se = args.se;
    }
  }
};
ChatRoomService_envoyerMessage_result.prototype = {};
ChatRoomService_envoyerMessage_result.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRUCT) {
        this.se = new ServiceException();
        this.se.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

ChatRoomService_envoyerMessage_result.prototype.write = function(output) {
  output.writeStructBegin('ChatRoomService_envoyerMessage_result');
  if (this.se) {
    output.writeFieldBegin('se', Thrift.Type.STRUCT, 1);
    this.se.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

ChatRoomService_enregistrerUtilisateur_args = function(args) {
  this.utilisateur = null;
  if (args) {
    if (args.utilisateur !== undefined) {
      this.utilisateur = args.utilisateur;
    }
  }
};
ChatRoomService_enregistrerUtilisateur_args.prototype = {};
ChatRoomService_enregistrerUtilisateur_args.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRUCT) {
        this.utilisateur = new Utilisateur();
        this.utilisateur.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

ChatRoomService_enregistrerUtilisateur_args.prototype.write = function(output) {
  output.writeStructBegin('ChatRoomService_enregistrerUtilisateur_args');
  if (this.utilisateur) {
    output.writeFieldBegin('utilisateur', Thrift.Type.STRUCT, 1);
    this.utilisateur.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

ChatRoomService_enregistrerUtilisateur_result = function(args) {
  this.se = null;
  if (args) {
    if (args.se !== undefined) {
      this.se = args.se;
    }
  }
};
ChatRoomService_enregistrerUtilisateur_result.prototype = {};
ChatRoomService_enregistrerUtilisateur_result.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRUCT) {
        this.se = new ServiceException();
        this.se.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

ChatRoomService_enregistrerUtilisateur_result.prototype.write = function(output) {
  output.writeStructBegin('ChatRoomService_enregistrerUtilisateur_result');
  if (this.se) {
    output.writeFieldBegin('se', Thrift.Type.STRUCT, 1);
    this.se.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

ChatRoomServiceClient = function(input, output) {
    this.input = input;
    this.output = (!output) ? input : output;
    this.seqid = 0;
};
ChatRoomServiceClient.prototype = {};
ChatRoomServiceClient.prototype.getListeMessage = function(callback) {
  if (callback === undefined) {
    this.send_getListeMessage();
    return this.recv_getListeMessage();
  } else {
    var postData = this.send_getListeMessage(true);
    return this.output.getTransport()
      .jqRequest(this, postData, arguments, this.recv_getListeMessage);
  }
};

ChatRoomServiceClient.prototype.send_getListeMessage = function(callback) {
  this.output.writeMessageBegin('getListeMessage', Thrift.MessageType.CALL, this.seqid);
  var args = new ChatRoomService_getListeMessage_args();
  args.write(this.output);
  this.output.writeMessageEnd();
  return this.output.getTransport().flush(callback);
};

ChatRoomServiceClient.prototype.recv_getListeMessage = function() {
  var ret = this.input.readMessageBegin();
  var fname = ret.fname;
  var mtype = ret.mtype;
  var rseqid = ret.rseqid;
  if (mtype == Thrift.MessageType.EXCEPTION) {
    var x = new Thrift.TApplicationException();
    x.read(this.input);
    this.input.readMessageEnd();
    throw x;
  }
  var result = new ChatRoomService_getListeMessage_result();
  result.read(this.input);
  this.input.readMessageEnd();

  if (null !== result.se) {
    throw result.se;
  }
  if (null !== result.success) {
    return result.success;
  }
  throw 'getListeMessage failed: unknown result';
};
ChatRoomServiceClient.prototype.envoyerMessage = function(message, callback) {
  if (callback === undefined) {
    this.send_envoyerMessage(message);
    this.recv_envoyerMessage();
  } else {
    var postData = this.send_envoyerMessage(message, true);
    return this.output.getTransport()
      .jqRequest(this, postData, arguments, this.recv_envoyerMessage);
  }
};

ChatRoomServiceClient.prototype.send_envoyerMessage = function(message, callback) {
  this.output.writeMessageBegin('envoyerMessage', Thrift.MessageType.CALL, this.seqid);
  var args = new ChatRoomService_envoyerMessage_args();
  args.message = message;
  args.write(this.output);
  this.output.writeMessageEnd();
  return this.output.getTransport().flush(callback);
};

ChatRoomServiceClient.prototype.recv_envoyerMessage = function() {
  var ret = this.input.readMessageBegin();
  var fname = ret.fname;
  var mtype = ret.mtype;
  var rseqid = ret.rseqid;
  if (mtype == Thrift.MessageType.EXCEPTION) {
    var x = new Thrift.TApplicationException();
    x.read(this.input);
    this.input.readMessageEnd();
    throw x;
  }
  var result = new ChatRoomService_envoyerMessage_result();
  result.read(this.input);
  this.input.readMessageEnd();

  if (null !== result.se) {
    throw result.se;
  }
  return;
};
ChatRoomServiceClient.prototype.enregistrerUtilisateur = function(utilisateur, callback) {
  if (callback === undefined) {
    this.send_enregistrerUtilisateur(utilisateur);
    this.recv_enregistrerUtilisateur();
  } else {
    var postData = this.send_enregistrerUtilisateur(utilisateur, true);
    return this.output.getTransport()
      .jqRequest(this, postData, arguments, this.recv_enregistrerUtilisateur);
  }
};

ChatRoomServiceClient.prototype.send_enregistrerUtilisateur = function(utilisateur, callback) {
  this.output.writeMessageBegin('enregistrerUtilisateur', Thrift.MessageType.CALL, this.seqid);
  var args = new ChatRoomService_enregistrerUtilisateur_args();
  args.utilisateur = utilisateur;
  args.write(this.output);
  this.output.writeMessageEnd();
  return this.output.getTransport().flush(callback);
};

ChatRoomServiceClient.prototype.recv_enregistrerUtilisateur = function() {
  var ret = this.input.readMessageBegin();
  var fname = ret.fname;
  var mtype = ret.mtype;
  var rseqid = ret.rseqid;
  if (mtype == Thrift.MessageType.EXCEPTION) {
    var x = new Thrift.TApplicationException();
    x.read(this.input);
    this.input.readMessageEnd();
    throw x;
  }
  var result = new ChatRoomService_enregistrerUtilisateur_result();
  result.read(this.input);
  this.input.readMessageEnd();

  if (null !== result.se) {
    throw result.se;
  }
  return;
};
