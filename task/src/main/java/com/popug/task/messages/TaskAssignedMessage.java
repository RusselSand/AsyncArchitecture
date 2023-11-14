/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.popug.task.messages;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class TaskAssignedMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6790890682874092883L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TaskAssignedMessage\",\"namespace\":\"com.popug.task.messages\",\"fields\":[{\"name\":\"userPublicId\",\"type\":\"string\"},{\"name\":\"taskPublicId\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TaskAssignedMessage> ENCODER =
      new BinaryMessageEncoder<TaskAssignedMessage>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TaskAssignedMessage> DECODER =
      new BinaryMessageDecoder<TaskAssignedMessage>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TaskAssignedMessage> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TaskAssignedMessage> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TaskAssignedMessage> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TaskAssignedMessage>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TaskAssignedMessage to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TaskAssignedMessage from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TaskAssignedMessage instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TaskAssignedMessage fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence userPublicId;
   private java.lang.CharSequence taskPublicId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TaskAssignedMessage() {}

  /**
   * All-args constructor.
   * @param userPublicId The new value for userPublicId
   * @param taskPublicId The new value for taskPublicId
   */
  public TaskAssignedMessage(java.lang.CharSequence userPublicId, java.lang.CharSequence taskPublicId) {
    this.userPublicId = userPublicId;
    this.taskPublicId = taskPublicId;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return userPublicId;
    case 1: return taskPublicId;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: userPublicId = (java.lang.CharSequence)value$; break;
    case 1: taskPublicId = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'userPublicId' field.
   * @return The value of the 'userPublicId' field.
   */
  public java.lang.CharSequence getUserPublicId() {
    return userPublicId;
  }


  /**
   * Sets the value of the 'userPublicId' field.
   * @param value the value to set.
   */
  public void setUserPublicId(java.lang.CharSequence value) {
    this.userPublicId = value;
  }

  /**
   * Gets the value of the 'taskPublicId' field.
   * @return The value of the 'taskPublicId' field.
   */
  public java.lang.CharSequence getTaskPublicId() {
    return taskPublicId;
  }


  /**
   * Sets the value of the 'taskPublicId' field.
   * @param value the value to set.
   */
  public void setTaskPublicId(java.lang.CharSequence value) {
    this.taskPublicId = value;
  }

  /**
   * Creates a new TaskAssignedMessage RecordBuilder.
   * @return A new TaskAssignedMessage RecordBuilder
   */
  public static com.popug.task.messages.TaskAssignedMessage.Builder newBuilder() {
    return new com.popug.task.messages.TaskAssignedMessage.Builder();
  }

  /**
   * Creates a new TaskAssignedMessage RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TaskAssignedMessage RecordBuilder
   */
  public static com.popug.task.messages.TaskAssignedMessage.Builder newBuilder(com.popug.task.messages.TaskAssignedMessage.Builder other) {
    if (other == null) {
      return new com.popug.task.messages.TaskAssignedMessage.Builder();
    } else {
      return new com.popug.task.messages.TaskAssignedMessage.Builder(other);
    }
  }

  /**
   * Creates a new TaskAssignedMessage RecordBuilder by copying an existing TaskAssignedMessage instance.
   * @param other The existing instance to copy.
   * @return A new TaskAssignedMessage RecordBuilder
   */
  public static com.popug.task.messages.TaskAssignedMessage.Builder newBuilder(com.popug.task.messages.TaskAssignedMessage other) {
    if (other == null) {
      return new com.popug.task.messages.TaskAssignedMessage.Builder();
    } else {
      return new com.popug.task.messages.TaskAssignedMessage.Builder(other);
    }
  }

  /**
   * RecordBuilder for TaskAssignedMessage instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TaskAssignedMessage>
    implements org.apache.avro.data.RecordBuilder<TaskAssignedMessage> {

    private java.lang.CharSequence userPublicId;
    private java.lang.CharSequence taskPublicId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.popug.task.messages.TaskAssignedMessage.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.userPublicId)) {
        this.userPublicId = data().deepCopy(fields()[0].schema(), other.userPublicId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.taskPublicId)) {
        this.taskPublicId = data().deepCopy(fields()[1].schema(), other.taskPublicId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing TaskAssignedMessage instance
     * @param other The existing instance to copy.
     */
    private Builder(com.popug.task.messages.TaskAssignedMessage other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.userPublicId)) {
        this.userPublicId = data().deepCopy(fields()[0].schema(), other.userPublicId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.taskPublicId)) {
        this.taskPublicId = data().deepCopy(fields()[1].schema(), other.taskPublicId);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'userPublicId' field.
      * @return The value.
      */
    public java.lang.CharSequence getUserPublicId() {
      return userPublicId;
    }


    /**
      * Sets the value of the 'userPublicId' field.
      * @param value The value of 'userPublicId'.
      * @return This builder.
      */
    public com.popug.task.messages.TaskAssignedMessage.Builder setUserPublicId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.userPublicId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'userPublicId' field has been set.
      * @return True if the 'userPublicId' field has been set, false otherwise.
      */
    public boolean hasUserPublicId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'userPublicId' field.
      * @return This builder.
      */
    public com.popug.task.messages.TaskAssignedMessage.Builder clearUserPublicId() {
      userPublicId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'taskPublicId' field.
      * @return The value.
      */
    public java.lang.CharSequence getTaskPublicId() {
      return taskPublicId;
    }


    /**
      * Sets the value of the 'taskPublicId' field.
      * @param value The value of 'taskPublicId'.
      * @return This builder.
      */
    public com.popug.task.messages.TaskAssignedMessage.Builder setTaskPublicId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.taskPublicId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'taskPublicId' field has been set.
      * @return True if the 'taskPublicId' field has been set, false otherwise.
      */
    public boolean hasTaskPublicId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'taskPublicId' field.
      * @return This builder.
      */
    public com.popug.task.messages.TaskAssignedMessage.Builder clearTaskPublicId() {
      taskPublicId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TaskAssignedMessage build() {
      try {
        TaskAssignedMessage record = new TaskAssignedMessage();
        record.userPublicId = fieldSetFlags()[0] ? this.userPublicId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.taskPublicId = fieldSetFlags()[1] ? this.taskPublicId : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TaskAssignedMessage>
    WRITER$ = (org.apache.avro.io.DatumWriter<TaskAssignedMessage>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TaskAssignedMessage>
    READER$ = (org.apache.avro.io.DatumReader<TaskAssignedMessage>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.userPublicId);

    out.writeString(this.taskPublicId);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.userPublicId = in.readString(this.userPublicId instanceof Utf8 ? (Utf8)this.userPublicId : null);

      this.taskPublicId = in.readString(this.taskPublicId instanceof Utf8 ? (Utf8)this.taskPublicId : null);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.userPublicId = in.readString(this.userPublicId instanceof Utf8 ? (Utf8)this.userPublicId : null);
          break;

        case 1:
          this.taskPublicId = in.readString(this.taskPublicId instanceof Utf8 ? (Utf8)this.taskPublicId : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










