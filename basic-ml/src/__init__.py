from keras import backend
from keras import layers
from keras import models
from keras import utils

from keras.applications import keras_modules_injection

def keras_modules_injection(base_fun):

    def wrapper(*args, **kwargs):
        if hasattr(keras_applications, 'get_submodules_from_kwargs'):
            kwargs['backend'] = backend
            kwargs['layers'] = layers
            kwargs['models'] = models
            kwargs['utils'] = utils
        return base_fun(*args, **kwargs)

    return wrapper

@keras_modules_injection
def ResNet50(*args, **kwargs):
    return resnet50.ResNet50(*args, **kwargs)