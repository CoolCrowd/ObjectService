// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: constraint.proto

package edu.kit.ipd.crowdcontrol.objectservice.proto;

/**
 * Protobuf type {@code crowdcontrol.Constraint}
 */
public  final class Constraint extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:crowdcontrol.Constraint)
    ConstraintOrBuilder {
  // Use Constraint.newBuilder() to construct.
  private Constraint(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Constraint() {
    id_ = 0;
    name_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Constraint(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw new RuntimeException(e.setUnfinishedMessage(this));
    } catch (java.io.IOException e) {
      throw new RuntimeException(
          new com.google.protobuf.InvalidProtocolBufferException(
              e.getMessage()).setUnfinishedMessage(this));
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return edu.kit.ipd.crowdcontrol.objectservice.proto.ConstraintOuterClass.internal_static_crowdcontrol_Constraint_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return edu.kit.ipd.crowdcontrol.objectservice.proto.ConstraintOuterClass.internal_static_crowdcontrol_Constraint_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint.class, edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>optional int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object name_;
  /**
   * <code>optional string name = 2;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>optional string name = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, name_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, name_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code crowdcontrol.Constraint}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:crowdcontrol.Constraint)
      edu.kit.ipd.crowdcontrol.objectservice.proto.ConstraintOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return edu.kit.ipd.crowdcontrol.objectservice.proto.ConstraintOuterClass.internal_static_crowdcontrol_Constraint_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return edu.kit.ipd.crowdcontrol.objectservice.proto.ConstraintOuterClass.internal_static_crowdcontrol_Constraint_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint.class, edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint.Builder.class);
    }

    // Construct using edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0;

      name_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return edu.kit.ipd.crowdcontrol.objectservice.proto.ConstraintOuterClass.internal_static_crowdcontrol_Constraint_descriptor;
    }

    public edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint getDefaultInstanceForType() {
      return edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint.getDefaultInstance();
    }

    public edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint build() {
      edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint buildPartial() {
      edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint result = new edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint(this);
      result.id_ = id_;
      result.name_ = name_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint) {
        return mergeFrom((edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint other) {
      if (other == edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int id_ ;
    /**
     * <code>optional int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>optional int32 id = 1;</code>
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>optional string name = 2;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string name = 2;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 2;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 2;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:crowdcontrol.Constraint)
  }

  // @@protoc_insertion_point(class_scope:crowdcontrol.Constraint)
  private static final edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint();
  }

  public static edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Constraint>
      PARSER = new com.google.protobuf.AbstractParser<Constraint>() {
    public Constraint parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new Constraint(input, extensionRegistry);
      } catch (RuntimeException e) {
        if (e.getCause() instanceof
            com.google.protobuf.InvalidProtocolBufferException) {
          throw (com.google.protobuf.InvalidProtocolBufferException)
              e.getCause();
        }
        throw e;
      }
    }
  };

  public static com.google.protobuf.Parser<Constraint> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Constraint> getParserForType() {
    return PARSER;
  }

  public edu.kit.ipd.crowdcontrol.objectservice.proto.Constraint getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

