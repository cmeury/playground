class CartesianProduct
  include Enumerable

	def initialize(seqA, seqB)
		@seqA = seqA
		@seqB = seqB		
	end

	def each
		@seqA.each do |a|
			@seqB.each do |b|
				yield [a,b]
			end
		end
	end
end
