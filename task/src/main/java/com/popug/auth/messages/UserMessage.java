/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.popug.auth.messages;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class UserMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2743013124846324551L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserMessage\",\"namespace\":\"com.popug.auth.messages\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"publicId\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"},{\"name\":\"role\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<UserMessage> ENCODER =
      new BinaryMessageEncoder<UserMessage>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<UserMessage> DECODER =
      new BinaryMessageDecoder<UserMessage>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<UserMessage> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<UserMessage> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<UserMessage> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<UserMessage>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this UserMessage to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a UserMessage from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a UserMessage instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static UserMessage fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private int id;
   private java.lang.CharSequence name;
   private java.lang.CharSequence publicId;
   private java.lang.CharSequence email;
   private java.lang.CharSequence role;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserMessage() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param publicId The new value for publicId
   * @param email The new value for email
   * @param role The new value for role
   */
  public UserMessage(java.lang.Integer id, java.lang.CharSequence name, java.lang.CharSequence publicId, java.lang.CharSequence email, java.lang.CharSequence role) {
    this.id = id;
    this.name = name;
    this.publicId = publicId;
    this.email = email;
    this.role = role;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return publicId;
    case 3: return email;
    case 4: return role;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: publicId = (java.lang.CharSequence)value$; break;
    case 3: email = (java.lang.CharSequence)value$; break;
    case 4: role = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public int getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(int value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'publicId' field.
   * @return The value of the 'publicId' field.
   */
  public java.lang.CharSequence getPublicId() {
    return publicId;
  }


  /**
   * Sets the value of the 'publicId' field.
   * @param value the value to set.
   */
  public void setPublicId(java.lang.CharSequence value) {
    this.publicId = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public java.lang.CharSequence getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(java.lang.CharSequence value) {
    this.email = value;
  }

  /**
   * Gets the value of the 'role' field.
   * @return The value of the 'role' field.
   */
  public java.lang.CharSequence getRole() {
    return role;
  }


  /**
   * Sets the value of the 'role' field.
   * @param value the value to set.
   */
  public void setRole(java.lang.CharSequence value) {
    this.role = value;
  }

  /**
   * Creates a new UserMessage RecordBuilder.
   * @return A new UserMessage RecordBuilder
   */
  public static com.popug.auth.messages.UserMessage.Builder newBuilder() {
    return new com.popug.auth.messages.UserMessage.Builder();
  }

  /**
   * Creates a new UserMessage RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserMessage RecordBuilder
   */
  public static com.popug.auth.messages.UserMessage.Builder newBuilder(com.popug.auth.messages.UserMessage.Builder other) {
    if (other == null) {
      return new com.popug.auth.messages.UserMessage.Builder();
    } else {
      return new com.popug.auth.messages.UserMessage.Builder(other);
    }
  }

  /**
   * Creates a new UserMessage RecordBuilder by copying an existing UserMessage instance.
   * @param other The existing instance to copy.
   * @return A new UserMessage RecordBuilder
   */
  public static com.popug.auth.messages.UserMessage.Builder newBuilder(com.popug.auth.messages.UserMessage other) {
    if (other == null) {
      return new com.popug.auth.messages.UserMessage.Builder();
    } else {
      return new com.popug.auth.messages.UserMessage.Builder(other);
    }
  }

  /**
   * RecordBuilder for UserMessage instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserMessage>
    implements org.apache.avro.data.RecordBuilder<UserMessage> {

    private int id;
    private java.lang.CharSequence name;
    private java.lang.CharSequence publicId;
    private java.lang.CharSequence email;
    private java.lang.CharSequence role;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.popug.auth.messages.UserMessage.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.publicId)) {
        this.publicId = data().deepCopy(fields()[2].schema(), other.publicId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.email)) {
        this.email = data().deepCopy(fields()[3].schema(), other.email);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.role)) {
        this.role = data().deepCopy(fields()[4].schema(), other.role);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing UserMessage instance
     * @param other The existing instance to copy.
     */
    private Builder(com.popug.auth.messages.UserMessage other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.publicId)) {
        this.publicId = data().deepCopy(fields()[2].schema(), other.publicId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.email)) {
        this.email = data().deepCopy(fields()[3].schema(), other.email);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.role)) {
        this.role = data().deepCopy(fields()[4].schema(), other.role);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public int getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'publicId' field.
      * @return The value.
      */
    public java.lang.CharSequence getPublicId() {
      return publicId;
    }


    /**
      * Sets the value of the 'publicId' field.
      * @param value The value of 'publicId'.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder setPublicId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.publicId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'publicId' field has been set.
      * @return True if the 'publicId' field has been set, false otherwise.
      */
    public boolean hasPublicId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'publicId' field.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder clearPublicId() {
      publicId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public java.lang.CharSequence getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder setEmail(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.email = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder clearEmail() {
      email = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'role' field.
      * @return The value.
      */
    public java.lang.CharSequence getRole() {
      return role;
    }


    /**
      * Sets the value of the 'role' field.
      * @param value The value of 'role'.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder setRole(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.role = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'role' field has been set.
      * @return True if the 'role' field has been set, false otherwise.
      */
    public boolean hasRole() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'role' field.
      * @return This builder.
      */
    public com.popug.auth.messages.UserMessage.Builder clearRole() {
      role = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserMessage build() {
      try {
        UserMessage record = new UserMessage();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.publicId = fieldSetFlags()[2] ? this.publicId : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.email = fieldSetFlags()[3] ? this.email : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.role = fieldSetFlags()[4] ? this.role : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<UserMessage>
    WRITER$ = (org.apache.avro.io.DatumWriter<UserMessage>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<UserMessage>
    READER$ = (org.apache.avro.io.DatumReader<UserMessage>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.id);

    out.writeString(this.name);

    out.writeString(this.publicId);

    out.writeString(this.email);

    out.writeString(this.role);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readInt();

      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      this.publicId = in.readString(this.publicId instanceof Utf8 ? (Utf8)this.publicId : null);

      this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);

      this.role = in.readString(this.role instanceof Utf8 ? (Utf8)this.role : null);

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readInt();
          break;

        case 1:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 2:
          this.publicId = in.readString(this.publicId instanceof Utf8 ? (Utf8)this.publicId : null);
          break;

        case 3:
          this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);
          break;

        case 4:
          this.role = in.readString(this.role instanceof Utf8 ? (Utf8)this.role : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










