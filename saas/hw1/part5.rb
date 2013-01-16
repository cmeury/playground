class Class
  def attr_accessor_with_history(attr_name)
    attr_name = attr_name.to_s   # make sure it's a string
    attr_reader attr_name        # create the attribute's getter
    class_eval %Q{

			def #{attr_name}_history
				@history ={} unless @history
				@history["#{attr_name}"] = [] unless @history["#{attr_name}"]
				return @history["#{attr_name}"]
			end

			def #{attr_name}=(value)
				@history = {} unless @history
				@history["#{attr_name}"] = [nil] unless @history["#{attr_name}"]
				@history["#{attr_name}"] << value unless value == nil
				@#{attr_name} = value
			end					
		}
  end
end
