LOCAL_PATH := $(call jni)

include $(CLEAR_VARS)

LOCAL_MODULE := myJNI
LOCAL_SRC_FILES:= increment.c
include $(BUILD_SHARED_LIBRARY)