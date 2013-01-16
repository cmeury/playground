class Numeric
  @@currencies = {'yen' => 0.013, 'euro' => 1.292, 'rupee' => 0.019, 'dollar' => 1}
  def method_missing(method_id)
    if @@currencies.has_key?(ensure_singular(method_id))
      self * @@currencies[ensure_singular(method_id)]
    else
      super
    end
  end

	def in(curr)
		if @@currencies.has_key?(ensure_singular(curr))
			self / @@currencies[ensure_singular(curr)]			
		else
			raise ArgumentError, "unknown currency", caller
		end
	end

	private
	
	def ensure_singular(currency)
		currency.to_s.gsub(/s$/, '')
	end
end

class String
	def palindrome?
		  stripped = self.gsub(/\W/, "").downcase
			stripped.reverse == stripped

	end
end

module Enumerable
	def palindrome?
			false if self.is_a? Hash
			self.to_a.reverse == self.to_a
	end
end

